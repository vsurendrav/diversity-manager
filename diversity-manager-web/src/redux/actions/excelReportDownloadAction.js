import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { ProgressBar } from "react-bootstrap";
import { useDispatch } from "redux-react-hook";

function excelReportDownloadAction(props) {
    const dispatch = useDispatch();
    const [showReport, setShowReport] = useState(false);
    const [loading, setLoading] = useState(false);
    const [confirmationPanel, setConfirmationPanel] = useState(false);
    const [reponseMessage, setResponseMessage] = useState("");
    const spinnerHide = loading == true ? "" : 'spinner-hide';

    useEffect(() => {
        if (showReport) {
            downloadReport();
        }
    }, [showReport == true]
    );

    function handleExport () {
        setShowReport(true);
    }

    function downloadReport() {
        let utl = "";
        setLoading(true);
        axios(
            {
                url: url,
                responseType: 'blob',
                headers: {
                    'content-type': 'application/force-downlaod'
                }
            }
        ).then(
            res => {
                if(res.status == 200 && res.data.type.endsWith('.sheet')) {
                    var url = window.URL.createObjectURL(res.data);
                    var a = document.createElement("a");
                    a.href = url;
                    a.download = res.headers['content-disposition'].split('"')[1];
                    a.click();
                    a.href = '';
                    setShowReport(true);
                    setLoading(false);
                    setConfirmationPanel(true);
                    setResponseMessage('File downloaded successfully.')
                } else {
                    res.data.staus.length > 0 ? setResponseMessage(res.data.staus) : setResponseMessage('File download failed.');
                }
            }
        ).catch(
            err => {
                setShowReport(true);
                setLoading(false);
                setConfirmationPanel(true);
                setResponseMessage('File download failed.')
            }
        )
    }

    function handleCLose() {
        setConfirmationPanel(false);
        setShowReport(false);
    }
  
}
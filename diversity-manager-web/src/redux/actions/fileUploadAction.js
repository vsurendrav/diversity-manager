import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";

export const FETCH_DIVERSE_DIMN_FILE = "FETCH_DIVERSE_DIMN_FILE";
export const fetchDiverseDimnFile = (defineLength, fullLength) => (
    {
        type: FETCH_DIVERSE_DIMN_FILE,
        payload: {defineLength,fullLength}
    }
);

export function fileUploadAction() {
    let url = "";
    const formData = new FormData();
    formData.append("file", file);

    return axios(
        {
            url: url,
            method: "POST",
            headers: {},
            data: formData
        }
    ).then(res => res.data)
}

export function fetchFileUploadAction (file) {
    return dispatch => {
        dispatch(fetchFileUploadActionBegin());
        return fileUploadAction(file).then(
            response => {
                dispatch(fetchFileUploadActionSuccess());
                return response.data;
            }
        ).catch(
            error => dispatch(fetchFileUploadActionError())
        )
    };
}
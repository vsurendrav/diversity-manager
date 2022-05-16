import axios from "axios";

function fetchDiversityDimessionsData() {

    const [diverseDimData, setDiverseDimData] = useState(null);

    const fortmatResponse = (res) => {
        return JSON.stringify(res, null, 2);
      };

    let url = 'https://hackathon/diverse-dimenssions-data';
    let options = {
        method: 'GET',
        url: url,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    };
    await axios(options).then (
        res => {
            setDiverseDimData(fortmatResponse(res));
        }
    ).catch(err => {
        setDiverseDimData(fortmatResponse(err.response?.data || err));
    });
}
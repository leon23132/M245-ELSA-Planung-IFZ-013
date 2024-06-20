import axios from 'axios';

const fetchData = async (url, setter, token) => {
    try {
        const response = await axios.get(url, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });
        if (response.data) {
            setter(response.data);
        }
    } catch (error) {
        console.error("Error fetching data:", error);
    }
};

export default fetchData;

function SubmitTestForm() {
    let url = "/feedback";
    const formData = new Map([
        ['user', document.getElementById("user").value],
        ['rating', document.getElementById("rating").value],
        ['comments', document.getElementById("comments").value]
    ]);

    let response = postFormDataAsJson({
        url,
        formData
    });
    alert('Thank you for your feedback.');
    //window.location.href = '/send_feedback/success';
}

async function postFormDataAsJson({
    url,
    formData
}) {
    const plainFormData = Object.fromEntries(formData.entries());
    const formDataJsonString = JSON.stringify(plainFormData);

    const fetchOptions = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: formDataJsonString,
    };

    const response = await fetch(url, fetchOptions);

    if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(errorMessage);
    }

    return response.json();
}
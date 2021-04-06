var vendors = [
    { "vendor_id": 0, "vendor_name": "Microsoft", "project_name": "Apollo Project"},
    { "vendor_id": 1, "vendor_name": "Intel", "project_name": "Hermes Project"},
    { "vendor_id": 2, "vendor_name": "Apple", "project_name": "Zeus Project"}
];

var fillTable = (vendors) => {
    var table = $('#vendorsTable').find('tbody');
    table.empty();
    for (var i = 0; i < vendors.length; i++) {
        var vendor = vendors[i];
        table.append(`
            <tr>
                <th scope="row">${vendor.vendor_id}</th>
                <td>${vendor.vendor_name}</td>
                <td>${vendor.project_name}</td>
                <td>
                    <button type="button" class="btn btn-warning" onclick="editRow(${vendor.vendor_id})">edit</button>
                    <button type="button" class="btn btn-danger" onclick="deleteRow(${vendor.vendor_id})">delete</button>
                </td>
            </tr>
        `);
    }
};

var addRow = () => {
    var vendor = {};
    var form = $('#addForm');
    vendor.vendor_id = vendors.length > 0 ? vendors[vendors.length - 1].vendor_id + 1 : 0;
    vendor.vendor_name = form.find("#vendorName").val();
    vendor.project_name = form.find("#projectName").val();
    vendors.push(vendor);

    $(':input', '#addForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
    fillTable(vendors);
}

var editRow = (id) => {
    resetForm();

    var index = -1;
    for (var i = 0; i < vendors.length; i++) {
        if (id === vendors[i].vendor_id) {
            index = i;
            break;
        }
    }
    if (index == -1) return;

    var form = $('#editForm');
    form.find("#vendorName").val(vendors[index].vendor_name);
    form.find("#projectName").val(vendors[index].project_name);
    form.find("button").click(() => {
        vendors[index].vendor_name = form.find("#vendorName").val();
        vendors[index].project_name = form.find("#projectName").val();

        resetForm();
        fillTable(vendors);
    });
    form.attr("hidden", false);
};

var deleteRow = (id) => {
    resetForm();

    for (var i = 0; i < vendors.length; i++) {
        if (id === vendors[i].vendor_id) {
            vendors.splice(i, 1);
            break;
        }
    }
    fillTable(vendors);
};

var resetForm = () => {
    var form = $('#editForm');
    form.find("button").off("click");
    form.attr("hidden", true);
    $(':input', '#editForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
}

$(document).ready(function () {
    fillTable(vendors);
});

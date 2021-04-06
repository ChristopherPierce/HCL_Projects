var deals = [
    { "deal_id": 0, "vendor_name": "Microsoft", "project_name": "Apollo Project", "project_cost": 1000 },
    { "deal_id": 1, "vendor_name": "Intel", "project_name": "Hermes Project", "project_cost": 10000 },
    { "deal_id": 2, "vendor_name": "Apple", "project_name": "Zeus Project", "project_cost": 100000 }
];

var fillTable = (deals) => {
    var table = $('#dealsTable').find('tbody');
    table.empty();
    for (var i = 0; i < deals.length; i++) {
        var deal = deals[i];
        table.append(`
            <tr>
                <th scope="row">${deal.deal_id}</th>
                <td>${deal.vendor_name}</td>
                <td>${deal.project_name}</td>
                <td>${deal.project_cost}</td>
                <td>
                    <button type="button" class="btn btn-warning" onclick="editRow(${deal.deal_id})">edit</button>
                    <button type="button" class="btn btn-danger" onclick="deleteRow(${deal.deal_id})">delete</button>
                </td>
            </tr>
        `);
    }
};

var addRow = () => {
    var deal = {};
    var form = $('#addForm');
    deal.deal_id = deals.length > 0 ? deals[deals.length - 1].deal_id + 1 : 0;
    deal.vendor_name = form.find("#vendorName").val();
    deal.project_name = form.find("#projectName").val();
    deal.project_cost = form.find("#projectCost").val();
    deals.push(deal);

    $(':input', '#addForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
    fillTable(deals);
}

var editRow = (id) => {
    resetForm();

    var index = -1;
    for (var i = 0; i < deals.length; i++) {
        if (id === deals[i].deal_id) {
            index = i;
            break;
        }
    }
    if (index == -1) return;

    var form = $('#editForm');
    form.find("#vendorName").val(deals[index].vendor_name);
    form.find("#projectName").val(deals[index].project_name);
    form.find("#projectCost").val(deals[index].project_cost);
    form.find("button").click(() => {
        deals[index].vendor_name = form.find("#vendorName").val();
        deals[index].project_name = form.find("#projectName").val();
        deals[index].project_cost = form.find("#projectCost").val();

        resetForm();
        fillTable(deals);
    });
    form.attr("hidden", false);
};

var deleteRow = (id) => {
    resetForm();

    for (var i = 0; i < deals.length; i++) {
        if (id === deals[i].deal_id) {
            deals.splice(i, 1);
            break;
        }
    }
    fillTable(deals);
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
    fillTable(deals);
});

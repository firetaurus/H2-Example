// function showinfo(data)
// {
//     $('#notes').html(''); // clean div data
//     $('#notes').html(data.notes);
//     return $("#extrainfo").html();
// }

$(document).ready(function() {

    $('#btnSearch').on( 'click', function () {

        $("#search").val("search");

        table.ajax.reload();

    } );

    var table = $('#datatable').DataTable({
        "processing": true,
        "serverSide": true,
        "searching": false,
        "deferLoading": 0,
        // "language": {
        //     "url": "js/Italian.json"
        // },
        "ajax": {
            "url": "/rest/users",
            "type": "GET",
            "pages": 5, // number of pages to cache
            "data": function ( d ) {
                d.form = jQuery("#formSearch").serialize();
                d.action = "getPersons";
            }
        },
        "columns":
            [
                {
                    "data": "id",
                    "defaultContent": '',
                    "searchable": false,
                    "orderable": false
                },
                {
                    "data": "name",
                    "defaultContent": 'Unknow',
                    "orderable": true
                },
                {
                    "data": "surname",
                    "defaultContent": 'Unknow',
                    "orderable": true
                },
                {
                    "data": "country",
                    "defaultContent": null,
                    "orderable": true
                }
            ],
        "createdRow": function( row, data, dataIndex ) {
            $('td', row).first().html(dataIndex + 1);
        },
        "columnDefs": [
            // {
            //     "targets": 4,
            //     "createdCell": function (td, cellData, rowData, row, col)  {
            //         if ( rowData.notes != null ) {
            //             $(td).addClass('details');
            //         }
            //     }
            // },
            // {
            //     "targets": "cell-datetype",
            //     "render": function ( data, type, row ) {
            //         return formatDate(data);
            //     }
            // },
            {
                "targets": "_all",
                "className": "dt-body-center"
            }
        ]
    });

    // sort / search callback function. Inside the column number is rigenerated
    table.on( 'order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();

    // Add event listener for opening and closing details
    // $('#datatable tbody').on('click', 'td.details', function () {
    //     var tr = $(this).closest('tr');
    //     var row = table.row( tr );
    //
    //     // close the detail
    //     $('#datatable tbody tr.shown').each(function (index, element) {
    //
    //         if (tr[0] != element)
    //         {
    //             var rowindex = $(element).index();
    //             var cRow = table.row(rowindex);
    //
    //             cRow.child.hide();
    //             $(element).removeClass('shown');
    //         }
    //     } );
    //
    //     if ( row.child.isShown() ) {
    //         // This row is already open - close it
    //         row.child.hide();
    //         tr.removeClass('shown');
    //     }
    //     else {
    //         // Open this row
    //         row.child( showinfo(row.data()) ).show();
    //         tr.addClass('shown');
    //     }
    // } );

});
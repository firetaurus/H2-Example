$(document).ready(function() {

    var table = $('#datatable').DataTable({
        "processing": true,
        "createdRow": function( row, data, dataIndex ) {
            $('td', row).first().html(dataIndex + 1);
        },
        "columnDefs": [
            {
                "targets": ["search-orderable"],
                "searchable": true,
                "orderable": true
            },
            {
                "targets": "_all",
                "className": "dt-body-center"
            }
        ]
    });

    // sort / search callback function. The function inside rigenerate the progressive number
    table.on( 'order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();

    // Add event listener for opening and closing details
    $('#datatable tbody').on('click', 'td.details', function () {
        var tr = $(this).closest('tr');
        var div = $(this).closest('td').find('div');
        var row = table.row( tr );

        // close the detail
        $('#datatable tbody tr.shown').each(function (index, element) {

            if (tr[0] != element)
            {
                var rowindex = $(element).index();
                var cRow = table.row(rowindex);

                cRow.child.hide();
                $(element).removeClass('shown');
            }
        } );

        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( $(div).html() ).show();
            tr.addClass('shown');
        }
    } );

});
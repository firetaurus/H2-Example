var editor;
$(document).ready(function () {
    var lang = navigator.language;
    // editor = new $.fn.dataTable.Editor( {
    // //     ajax: "",
    //     table: "#dtBasicExample",
    //     fields: [ {
    //         label: "First name:",
    //         name: "first_name"
    //     }, {
    //         label: "Last name:",
    //         name: "last_name"
    //     }, {
    //         label: "Username:",
    //         name: "username"
    //     }, {
    //         label: "Country:",
    //         name: "country"
    //     }, {
    //         label: "City:",
    //         name: "city"
    //     }, {
    //         label: "Zip_code:",
    //         name: "zip"
    //     }
    //     ]
    // } );

    // Activate the bubble editor on click of a table cell
    $('#dtBasicExample').on( 'click', 'tbody td:not(:first-child)', function (e) {
        editor.bubble( this );
    } );

    $('#dtBasicExample').DataTable({
        "language": {
            "url": "/js/" + lang + ".json"
        }//,
        // order: [[ 1, 'asc' ]],
        // columns: [
        //     {
        //         data: null,
        //         defaultContent: '',
        //         className: 'select-checkbox',
        //         orderable: false
        //     },
        //     // { data: "id" },
        //     { data: "first_name" },
        //     { data: "last_name" },
        //     { data: "username" },
        //     { data: "country" },
        //     { data: "city" },
        //     { data: "zip_code"}
        // ],
        // select: {
        //     style:    'os',
        //     selector: 'td:first-child'
        // },
        // buttons: [
        //     { extend: "create", editor: editor },
        //     { extend: "edit",   editor: editor },
        //     { extend: "remove", editor: editor }
        // ]
    });
    $('.dataTables_length').addClass('bs-select');



});
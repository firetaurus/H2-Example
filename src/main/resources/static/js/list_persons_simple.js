$(document).ready(function () {
    $('#dtBasicExample').DataTable({
        "language": {
            "url": "/js/Italian.json"
        }
    });
    $('.dataTables_length').addClass('bs-select');
});
$(document).ready(function() {

    $(".complete-checkbox").on("click", function() {
        if (this.checked) {
            $(this).closest("tr").addClass("table-success text-decoration-line-through");
        } else {
            $(this).closest("tr").removeClass("table-success text-decoration-line-through");
        }
    });

    $(".edit-button").on("click", function(event) {
        event.preventDefault();
        var href = "/tasks/" + $(this).attr("id").substr(-1) + "/edit";

        $.get(href, function(task) {
            $("#inputTitle").val(task.title);

            var complete = (task.complete === "true");
            $("#completeCheck").prop("checked", complete);
        });

        var editModal = new bootstrap.Modal(document.getElementById('exampleModal'));
        editModal.show();
    });

    $("#exampleModal").on("hidden.bs.modal", function(e) {
        $(this).find("#edit-form")[0].reset();
    });

});

$(document).ready(function() {

    $(".complete-checkbox").change(function () {
        if (this.checked) {
            $(this).closest("tr").css("text-decoration", "line-through");
            $(this).closest("tr").addClass("table-success");
        } else {
            $(this).closest("tr").css("text-decoration", "none");
            $(this).closest("tr").removeClass("table-success");
        }
    });

    $(".edit-button").on("click", function(event) {
        event.preventDefault();
        var href = "/tasks/" + $(this).attr("id").substr(-1) + "/edit";

        $.get(href, function(task) {
            $("#inputTitle").val(task.title);

            var flag = (task.is_complete === "true");
            $("#completeCheck").attr("checked", flag);
        });

        var editModal = new bootstrap.Modal(document.getElementById('exampleModal'));
        editModal.show();
    });

});

let addBtn = $('#AddPass');
addBtn.click(() => {
    let i = addBtn.val();
    console.log(i);
    $('#PassContainer').append(
        `<h3>Passenger: ${(i*1)+1}</h3>
        <label for="name${i}">Name</label><br>
        <input class="form-control" id="name${i}" name="name${i}" type="text" required><br><br
        <label for="age${i}">Age</label><br>
        <input class="form-control" id="age${i}" name="age${i}" type="number" required/><br><br>
        <label for="gender${i}">Gender</label><br>
        <input class="form-control" id="gender${i}" name="gender${i}" type="text" required><br><br>`);
    i = (i * 1) +1;
    addBtn.val(i);
    $('#pNum').val(i);
});
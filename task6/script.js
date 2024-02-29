let data = localStorage.getItem("EmployeeDetails") ? JSON.parse(localStorage.getItem("EmployeeDetails")) : []

// READ ALL EMPLOYEES DETAILS
const info = () => {
    if(data.length == 0) {
        document.querySelector('.message').style.display = 'contents'
    }
    else {
        document.querySelector('.message').style.display = 'none'
    }
    let row = "";

    data.map((e, index) => {
        row += `<tr>
            <td>${index + 1}</td>    
            <td>${e.name}</td>    
            <td>${e.email}</td>    
            <td>${e.mobile}</td>    
            <td>

            <!-- Button trigger modal -->
            <button type="button" id="update" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#update${index}" onclick="show(${index})">
            Edit
            </button>

            <!-- Modal -->
            <div class="modal fade" id="update${index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Update info</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form class="text-start">
                        <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Employee Name</label>
                        <input type="text" class="form-control" id="uename${index}" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Email</label>
                        <input type="email" class="form-control" id="ueemail${index}">
                        </div>
                        <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="uemobile${index}">
                        </div>
                        <button type="button" class="btn btn-primary" onclick="updateRow(${index})" data-bs-dismiss="modal" id="update${index}">Submit</button>
                    </form>
                    </div>
                </div>
            </div>
            </div>

            <button type="button" class="btn btn-primary" onclick={deleteRow(${index})}>Delete</button>

            </td>        
        </tr>`
    })

    document.getElementById('row').innerHTML = row
}

// ADD EMPLOYEE DETAILS
const addRow = () => {
    let name = document.getElementById('ename').value;
    let email = document.getElementById('eemail').value;
    let mobile = document.getElementById('emobile').value;

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const mobileRegex = /^\+?[0-9\s-]{10}$/


    if(name === null || name === "") {
        alert('Name must not be empty')
    }
    else if(!emailRegex.test(email)) {
        alert("Email is not in the correct format")
    }
    else if(!mobileRegex.test(mobile)) {
        alert("Phone number is not in the right format")
    }
    else {
        data.push({ name: name, email: email, mobile: mobile })
    
        localStorage.setItem("EmployeeDetails", JSON.stringify(data))
        document.getElementById('ename').value = ""
        document.getElementById('eemail').value = ""
        document.getElementById('emobile').value = ""
        
    }
    document.getElementById('ename').value = "";
    document.getElementById('eemail').value = ""
    mobile = document.getElementById('emobile').value = ""
    info()
}

// DELETE EMPLOYEE DETAILS
const deleteRow = (index) => {
    data.splice(index, 1)
    localStorage.setItem("EmployeeDetails", JSON.stringify(data))
    info()
}

// UPDATE EMPLOYEE DETAILS
const updateRow = (index) => {
    oldData = data[index];
    oldData.name = document.getElementById(`uename${index}`).value
    oldData.email = document.getElementById(`ueemail${index}`).value
    oldData.mobile = document.getElementById(`uemobile${index}`).value;
    data[index] = oldData

    localStorage.setItem("EmployeeDetails", JSON.stringify(data))
    info()
}

const show = (index) => {
    document.getElementById(`uename${index}`).value = data[index].name
    document.getElementById(`ueemail${index}`).value = data[index].email
    document.getElementById(`uemobile${index}`).value = data[index].mobile
}
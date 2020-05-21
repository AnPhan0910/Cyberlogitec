//Hiển thị bảng Student
var studentTable = {
		template: '\
    	<table class="table table-hover">\
		<thead>\
			<tr>\
				<th>ID</th>\
				<th>Name</th>\
				<th>Branch</th>\
				<th>Percentage</th>\
				<th>Phone</th>\
				<th>Email</th>\
			</tr>\
		</thead>\
		<tbody>\
			<tr v-for="student in dataStudentList" v-on:click="showInfo(student)">\
				<td>{{student.id}}</td>\
				<td>{{student.name}}</td>\
				<td>{{student.branch}}</td>\
				<td>{{student.percentage}}</td>\
				<td>{{student.phone}}</td>\
				<td>{{student.email}}</td>\
			</tr>\
		</tbody>\
		</table>\
		',
		props: ['dataStudentList'],
		methods: {
			showInfo: function(student){
				info.student = student
			}
		}
};

//Lấy data truyền dữ liệu vào bảng
var studentList = new Vue({
	el: '#vue-student-list',
    data: {
        studentList: []
    },
    components: {
        'student-table': studentTable
    },
    computed: {},
    methods: {
        updateData: function() {
            var self = this;
            axios
                .get("/getStudentList")
                .then(data => {
                    self.studentList = data.data;
                })
                .catch(err => {
                    console.log("Something wrong while try to get user");
                    console.log(err);
                });
        },
    },
    created: function() {
        this.updateData();
    }
});

//Biến cho search
var stu = new Vue({
	el: "#menuSearch",
	data: {
		student: {
			name: null,
			branch: null,
			percentage: null,
			phone: null,
			email: null
		}
	}
});

//Biến cho thông tin bên cột trái
var info = new Vue({
	el: "#infoStudent",
	data: {
		student: {
			id: 0
		}
	}
});


$(document).ready(function() {
	
	//Function search
	$("#search").click(function() {
		//console.log(stu.student);
		var data = stu.student;
		
		axios.post("/search", data)
			.then(data => {
				studentList.studentList = data.data;
				
			})
			.catch(err => {
                console.log("Something wrong while try to get user");
                console.log(err);
            });
	});
	
	//Process btn id = save
	$("#save").click(function() {
//		console.log(info.student);
		var data = info.student;
		
		axios.post("/add", data)
			.then(data => {
				studentList.updateData();
				info.student = {
						id: 0
				};
				if(data.data = 1) {
					alert("Thao tác thành công");
				} else {
					alert("Thao tác thất bại");
				}
			}).catch(err => {
				console.log("Something wrong while try to get user");
                console.log(err);
			});
	});
	
	//Process btn id = "delete"
	$("#delete").click(function() {
		var data = info.student;
		
		axios.post("/del", data)
		.then(data => {
			studentList.updateData();
			info.student = {
					id: 0
			};
			if(data.data = 1) {
				alert("Thao tác thành công");
			} else {
				alert("Thao tác thất bại");
			}
		}).catch(err => {
			console.log("Something wrong while try to get user");
            console.log(err);
		});
	});
	
	//Process btn id = "cancel"
	$("#cancel").click(function() {
		info.student = {
				id: 0
		};
	});
});
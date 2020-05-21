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
			<tr v-for="student in dataStudentList">\
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


$(document).ready(function() {
	
	//Function search
	$("#search").click(function() {
		console.log(stu.student);
		var data = stu.student;
		
		axios.post("/search", data)
			.then(data => {
				studentList.studentList = data.data;
				studentList.updateData();
			})
			.catch(err => {
                console.log("Something wrong while try to get user");
                console.log(err);
            });
	});
});
var data=new Array()
    $(document).ready(function(){
        if(localStorage.getItem("storeddata")!=null)      
            data=JSON.parse(localStorage.getItem("storeddata"));
});

$("#upload").click(function () {
            var k1=data.length;
            var regex = /^([a-zA-Z0-9\s_\\.\-:\()\g])+(.csv)$/;
            if (regex.test($("#fileUpload").val().toLowerCase())) {
                if (typeof (FileReader) != "undefined") {
                    var reader = new FileReader();
                    reader.readAsText($("#fileUpload")[0].files[0]);
                    
                    reader.onload = function (e) {
                        var rows = e.target.result.split("\r\n");
                        var req="name,email,phone";
                        var giv=(rows[1].toString()).trim();
                        if(req===giv){
                        var html= "<table border='1'>";
                        for (var i = 0; i < rows.length; i++) {
                            var cells = rows[i].split(",");
                            if (cells.length > 1) {
                                if(cells[2]!="phone"){
                                	$("#name").val(cells[0].replace(/"/g,''));
                                    $("#email").val(cells[1].replace(/"/g,''));
                                    $("#phone").val(cells[2].replace(/"/g,''));
                                    $("#sub_btn").trigger('click');
                                    data=JSON.parse(localStorage.getItem("storeddata"));
                                       
                                }
                            }
                        }
                        if(k1!=data.length){
                        $("#dvCSV").css("color","green");
                        $("#dvCSV").html("Uploaded Successful");
                        }else{
                        $("#dvCSV").css("color","red");
                        $("#dvCSV").html("Duplicate Data Found!!");
                        }
                    }
                    else
                    {
                    	$(dvCSV).css("color","red");
                    	$(dvCSV).html("Data is not in right format(name,email,phone)!!");
                    }
                    }
                } else {
                    alert("This browser does not support HTML5.");
                }
            } else {
                alert("Please upload a valid CSV file.");
            }
        });

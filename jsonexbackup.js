
var data=new Array();
    $(document).ready(function(){
        if(localStorage.getItem("storeddata")!=null)      
            data=JSON.parse(localStorage.getItem("storeddata"));
    });
    $(sub_btn).click(function(){
            var n=$("#name").val();
            var e=$(email).val();
            var p=$(phone).val();
            $("#success").css("color","red");
            if(n.length<3){
                $("#success").html("Name should be more than 3 characters");   
                
            }
            else if(e.indexOf('@') < 0 || e.indexOf('.') < 0 || e.lastIndexOf('.')<e.indexOf('@') || (e.lastIndexOf('.')+1)>=(e.length)) {
                $("#success").html("invalid Email Address");   
                
            }
            else if(p.length!=10){
                $("#success").html("Enter a 10-digit Mobile Number");  
                
            }
            else{
                dataadd();
            }
    });

    $(gen_btn).click(function(){
        JSONToCSVConvertor(data, "Submitted Details");   
    });

    $(view_btn).click(function(){
        var html='';
        if(data.length>0)
        {
            html+= "<table border='1'>";
            html+="<tr><th>name</th><th>email</th><th>phone</th><th colspan='2'>Actions</th></tr>";
        for (var i = 0; i < data.length; i++) {
        html+="<tr>";
        html+="<td>"+data[i].name+"</td>";
        html+="<td>"+data[i].email+"</td>";
        html+="<td>"+data[i].phone+"</td>";
        html+="<td><button onclick='javascript: deletef("+i+")'>Delete</button></td>";
                html+="<td><button onclick='javascript: modify("+i+")'>Update</button></td>";
        html+="</tr>";
        }
        html+="</table>";
    }else
        html+="<p style='color:red;'>No data found</p>";
    
    $("#viewdata").html(html);   
    $(view_btn).hide();
    });

    $(updone).click(function(){
        var n=$(nameupd).val();
            var e=$(emailupd).val();
            var p=$(phoneupd).val();
            var x=$(flagupd).val();
            var flag1=1;
            $("#success1").css("color","red");
            if(n.length<3){
                $("#success1").html("Name should be more than 3 characters");   
                
            }
            else if(e.indexOf('@') < 0 || e.indexOf('.') < 0 || e.lastIndexOf('.')<e.indexOf('@') || (e.lastIndexOf('.')+1)>=(e.length)) {
                $("#success1").html("invalid Email Address");   
                
            }
            else if(p.length!=10){
                $("#success1").html("Enter a 10-digit Mobile Number");   
            }
            else{
                for(i=0;i<data.length;i++)
                if(data[i].email==e || data[i].phone==p)
                if(i!=x)
                flag1=0;
                if(flag1==1){
                data[x].name=n;
                data[x].email=e;
                data[x].phone=p;
                alert("Update Successfull!!");
                $("#updatedata").hide();
                $("#view_btn").trigger('click');
                localStorage.setItem("storeddata",JSON.stringify(data));
                }
                else
                    $("#success1").html("Duplicate Data entered");
            }
    });

    $(search).click(function(){
        var ser=$(searchitem).val();
        var htm="";
        
        for(var i=0;i<data.length;i++)
            if(ser==data[i].name || ser==data[i].email || ser==data[i].phone)
            {
               
               htm=htm+data[i].name+" "+data[i].email+" "+data[i].phone+"<br>";
            }
            
            if(htm!=""){
                $(searchoutput).css("color","black");
                $(searchoutput).html(htm);
            }
            else{
                $(searchoutput).css("color","red");    
                $(searchoutput).html("No Searched Data Found!!");
            }
            
    });

    function deletef(x){
        data.splice(x,1);
        localStorage.setItem("storeddata",JSON.stringify(data));
        $("#view_btn").trigger('click');
    }

    function modify(x){
        $("#updatedata").show();
        $("#nameupd").val(data[x].name);
        $("#emailupd").val(data[x].email);
        $("#phoneupd").val(data[x].phone);
        $("#flagupd").val(x);
    }

    function dataadd(){
        var inputdata = {};
        var flag1=1;
        inputdata.name = $("#name").val();
        inputdata.email = $(email).val();
        inputdata.phone = $(phone).val();
        $("#name").val("");
        $(email).val("");
        $(phone).val("");

        for(i=0;i<data.length;i++)
            if(data[i].email==inputdata.email || data[i].phone==inputdata.phone )
                flag1=0;
        if(flag1==1){
        data.push(inputdata);
        localStorage.setItem("storeddata",JSON.stringify(data));
        $("#success").css("color","green");
        $("#success").html("Thanks for submission!! will contact you shortly.");
        $("#view_btn").trigger('click');        
        }
        else
            $("#success").html("duplicate data entered!!");
    }

function JSONToCSVConvertor(JSONData, ReportTitle) {
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    
    var CSV = '';    
    
    CSV += ReportTitle + '\r\n\n';

    
        var row = "";
        
        for (var index in arrData[0]) {
            
            row += index + ',';
        }

        row = row.slice(0, -1);
        
        CSV += row + '\r\n';
    
    if(arrData.length>0){
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        
        for (var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }

        row.slice(0, row.length - 1);
        
        CSV += row + '\r\n';
    }

    if (CSV == '') {        
        alert("Invalid data");
        return;
    }   
    
    var fileName = ReportTitle.replace(/ /g,"_");   
    
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

    var link = document.createElement("a");    
    link.href = uri;
    
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    }
    else{
        $("#dwntxt").css("color","red");
        $("#dwntxt").html("No Data found to download!!");
    }
}

$("#upload").click(function () {
            var regex = /^([a-zA-Z0-9\s_\\.\-:\()\g])+(.csv)$/;
            if (regex.test($("#fileUpload").val().toLowerCase())) {
                if (typeof (FileReader) != "undefined") {
                    var reader = new FileReader();
                    var html= "<table border='1'>";
                    reader.onload = function (e) {
                        var rows = e.target.result.split("\r\n");
                        for (var i = 0; i < rows.length; i++) {
                            var cells = rows[i].split(",");
                            if (cells.length > 1) {
                                if(cells[2]=="phone")
                                html+="<tr><th>name</th><th>email</th><th>phone</th></tr>";
                                else{
                                    html+="<tr>";
                                    html+="<td>"+cells[0].replace(/"/g,' ')+"</td>";
                                    html+="<td>"+cells[1].replace(/"/g,' ')+"</td>";
                                    html+="<td>"+cells[2].replace(/"/g,' ')+"</td>";
                                    html+="</tr>";
                                }

                            }
                        }
                        html+="</table>";
                        $(dvCSV).html(html);
                    }
                    reader.readAsText($("#fileUpload")[0].files[0]);
                } else {
                    alert("This browser does not support HTML5.");
                }
            } else {
                alert("Please upload a valid CSV file.");
            }
        });
var data=new Array()
    $(document).ready(function(){
        if(localStorage.getItem("storeddata")!=null)      
            data=JSON.parse(localStorage.getItem("storeddata"));
    });

function modify(x){
        $("#updatedata").show();
        $("#nameupd").val(data[x].name);
        $("#emailupd").val(data[x].email);
        $("#phoneupd").val(data[x].phone);
        $("#flagupd").val(x);
    }

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
                if(data[i].email==e)
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

    function deletef(x){
        data.splice(x,1);
        localStorage.setItem("storeddata",JSON.stringify(data));
        $("#view_btn").trigger('click');
    }
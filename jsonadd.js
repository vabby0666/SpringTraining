
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
            else if(p.length!=10 || isNaN(p)){

                $("#success").html("Enter a 10-digit Mobile Number");  
                
            }
            else{
                dataadd();
            }
    });
    
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
            if(data[i].email==inputdata.email)
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

function validate(evt) {
    var key=evt.keyCode;
    key=String.fromCharCode(key);

    if(isNaN(key)){
        evt.returnValue=false;
    }   
}

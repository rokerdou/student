
function onCreated()
    
	local root = view{id="a",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#303030",alpha="10"}
	root:addChild(view{margintop="0%",marginleft="0%",width="1000%",height="110%",backgroundcolor="#030303"})
 	root:addChild(view{margintop="100%",marginleft="0%",width="1000%",height="10%",backgroundcolor="#1C86EE"})
	root:addChild(button{margintop="8%",marginleft="250%",width="500%",height="95%",textcolor="#EAEAEA",text="学生信息管理系统",alpha="100"})
	local centers = view{id="center",margintop="110%",marginleft="0%",width="1000%",height="890%",backgroundcolor="#303030"}
	
	createStudent(centers)
	root:addChild(centers)
	return  root
end
function createStudent(centers)
local btn = button{id="newstu_btn",marginleft="200%",margintop="200%",width="600%",height="89%",text="修改个人信息",Onclick="Onclick",textcolor="#EAEAEA",fontsize="20"}
local btns = button{id="newstu_btn",marginleft="200%",margintop="200%",width="600%",height="89%",text="修改个人信息",Onclick="Onclick",textcolor="#EAEAEA",fontsize="20"}

centers:addChild(btn)
end
function Onclick()
App:switchPage("updatestu");


end
function OnFronted()
end
function OnNavBack()
App:popPage();
end
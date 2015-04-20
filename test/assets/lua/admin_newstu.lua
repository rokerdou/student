
local texts ={"学号","姓名","密码","性别","班号","时间","省份","身份证号"}
local ids ={"id","name","pwd","sex","classid","time","province","cardid"}
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
local checksex="男"
function createStudent(centers)
	local btn_top
	for i=1, #(texts) do  
		local top = 30+95*(i-1)
		local tops = 32+95*(i-1)
	 	centers:addChild(button{margintop=tostring(top).."%",marginleft="180%",width="180%",height="80%",textcolor="#EAEAEA",text=texts[i],alpha="39",fontsize="15"})
	 	if i~=4 then
		centers:addChild(edittext{id="stu"..ids[i],margintop=tostring(tops).."%",marginleft="380%",width="400%",height="70%",textcolor="#000000",backgroundcolor="#EAEAEA",fontsize="15"})
		else
	--root:addChild(checkbox{id="checkbox3",margintop="500%",marginleft="700%",width="100%",height="70%",Onclick="checkbox3_on"})

		centers:addChild(checkbox{id="sex1",margintop=tostring(tops).."%",marginleft="380%",width="100%",height="70%",Onclick="sex1_on"})
		centers:addChild(button{margintop=tostring(tops).."%",marginleft="500%",width="100%",height="70%",text="男",textcolor="#ffffff",alpha="100"})
		centers:addChild(checkbox{id="sex2",margintop=tostring(tops).."%",marginleft="620%",width="100%",height="70%",Onclick="sex2_on"})
		centers:addChild(button{margintop=tostring(tops).."%",marginleft="740%",width="100%",height="70%",text="女",textcolor="#ffffff",alpha="100"})


		end
		if i==#(texts) then
		btn_top=tops+70+20
		end
	end 
	centers:addChild(button{id="btn_submit",Onclick ="btn_submit_Onclik",margintop=tostring(btn_top).."%",marginleft="200%",width="250%",height="80%",text="提交",textcolor="#0A0A0A",backgroundcolor="#ADFF2F"})
	centers:addChild(button{id="btn_clear",margintop=tostring(btn_top).."%",marginleft="500%",width="250%",height="80%",text="重置",textcolor="#0A0A0A",backgroundcolor="#ADFF2F"})

end
function sex1_on()
if sex1:getIscheck() then
	checksex="男"
	sex2:setIscheck(false)
end


end
function btn_submit_Onclik()
	busy:show("正在录入");
service:addNewStudent(stuid:getText(),stuname:getText(),stupwd:getText(),checksex,stuclassid:getText(),
	stutime:getText(),stucardid:getText(),stuprovince:getText(),
	function ( msg)
		busy:dismiss()
		toast:show(msg)


	end,
	function ( msg )
		busy:dismiss()
		toast:show(msg)
	end
	)
end
function sex2_on()
if sex2:getIscheck() then
	checksex="女"
	sex1:setIscheck(false)
end


end
function Onclick()
App:switchPage("admin_newstu");


end
function OnFronted()
end
function OnNavBack()
App:switchPage("admin_main");
end
local math = require('math')  
function Onclick()

end
function sOnclick()
App:pushPage("admin_main");
end
local login_type=1;
function onCreated()
    
	local root = view{id="at",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#303030"}
	--root:addChild(view{marginleft="0%",margintop="0%",width="1000%",height="200%",backgroundimage="image/fengjing10.png",alpha="50"})
	root:addChild(view{marginleft="225%",margintop="0%",width="550%",height="180%",backgroundimage="image/logo.png"})
	local login_btn = button{id="login_btn",marginleft="250%",margintop="600%",width="500%",height="100%",text="登陆",Onclick="Login",backgroundcolor="#ccff11"}
	root:addChild(edittext{id="user",marginleft="250%",margintop="300%",width="550%",height="80%",fontsize="12",backgroundcolor="#ffffff",alpha="50"})
	root:addChild(edittext{id="pwd",marginleft="250%",margintop="400%",width="550%",height="80%",fontsize="12",backgroundcolor="#ffffff",alpha="50",type="password"})

	root:addChild(login_btn)
	root:addChild(button{margintop="900%",marginleft="0%",width="1000%",backgroundcolor="#000000",height="100%",textcolor="#EAEAEA",text="窦佳毕业设计",alpha="50"})
	
	--local checkline=view{marginleft="0%",margintop="500%",width="1000%",height="80%",backgroundcolor="#cccccc",alpha="50"}
	root:addChild(checkbox{id="checkbox1",margintop="500%",marginleft="50%",width="100%",height="70%",Onclick="checkbox1_on"})
	root:addChild(button{margintop="500%",marginleft="130%",text="学生",fontsize="15",textcolor="#EAEAEA",width="200%",height="70%",alpha="100"})
	root:addChild(checkbox{id="checkbox2",margintop="500%",marginleft="420%",width="100%",height="70%",Onclick="checkbox2_on"})
	root:addChild(button{margintop="500%",marginleft="520%",text="教师",fontsize="15",textcolor="#EAEAEA",width="200%",height="70%",alpha="100"})
	root:addChild(checkbox{id="checkbox3",margintop="500%",marginleft="700%",width="100%",height="70%",Onclick="checkbox3_on"})
	root:addChild(button{margintop="500%",marginleft="820%",text="管理员",fontsize="15",textcolor="#EAEAEA",width="200%",height="70%",alpha="100"})

	--root:addChild(checkline)
	return  root
end

function Login()

Log:i("进入了登陆函数")
busy:show("正在登陆中");
busy:dismiss() App:pushPage("admin_main")
--login:Login(user:getText(),pwd:getText(),login_type,function() busy:dismiss() App:pushPage("admin_main") toast:show("登陆成功") end,function(msg) busy:dismiss() toast:show(msg) end);
Log:i("退出登陆函数")

--busy:dismiss();
end
function checkbox1_on(  )
	if checkbox1:getIscheck() then
		login_type=1;
	
		checkbox2:setIscheck(false)
		checkbox3:setIscheck(false)
	end
	-- body
end
function checkbox2_on(  )
	if checkbox2:getIscheck() then
		login_type=2
	
		checkbox1:setIscheck(false)
		checkbox3:setIscheck(false)
	
	end
	-- body
end
function checkbox3_on(  )
	if checkbox3:getIscheck() then
		login_type=3
		checkbox1:setIscheck(false)
		checkbox2:setIscheck(false)
	end
end
function OnNavBack()
App:popPage();
end
function OnFronted()
end
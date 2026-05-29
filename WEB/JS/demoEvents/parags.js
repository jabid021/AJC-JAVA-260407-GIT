//paragPrincipal.onclick=function(){alert("tpt");}
titrePrincipal.onmouseover = function()
{
  paragPrincipal.style.color="red";
  paragPrincipal.style.fontSize="35px";
};


titrePrincipal.onmouseout = function()
{
  paragPrincipal.style.color="black";
  paragPrincipal.style.fontSize="16px";
};

content.onclick=demoEventSouris;
content.ondblclick=demoEventSouris;
content.onmouseover=demoEventSouris;
//content.onmousemove=demoEventSouris;


//La fonction demoEventSouris est à l'écoute de l'evenement click => Listener
function demoEventSouris(event)
{
  if(event.type=="click")
  {
    content.style.backgroundColor="#008B8B";
  }
  else if(event.type=="dblclick")
  {
    content.style.backgroundColor="#F5E6A3";
  }
  else if(event.type=="mouseover")
  {
    content.style.backgroundColor=" #FBCEB1";
  }
}


choixColor.onfocus = function()
{
paragPrincipal.style.border="solid black 2px";
}

choixColor.onblur = function()
{
paragPrincipal.style.border="none";
}
choixColor.oninput = function()
{
paragPrincipal.style.color= choixColor.value;
}

btnResetColor.onclick = function()
{
choixColor.value="#000000";
paragPrincipal.style.color="#000000";
}

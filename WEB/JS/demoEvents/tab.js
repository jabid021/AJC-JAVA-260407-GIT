function affichePersonne(index)
{
  let id = tab.rows[index].cells[0].textContent;
  let prenom = tab.rows[index].cells[1].textContent;
  let nom = tab.rows[index].cells[2].textContent;

  affichePersonneH1.innerHTML=`${prenom} ${nom} (${id})`;
}

btnAjouter.onclick=ajouterTableau;


function ajouterTableau()
{
  let id = document.getElementById("input-id");
  let prenom =  document.getElementById("input-prenom");
  let nom =  document.getElementById("input-nom").value;

  tab.innerHTML+=`<td>${id.value}</td><td>${prenom.value}</td><td>${nom}</td><td><input type="button"onClick=affichePersonne(${tab.rows.length})  value="Afficher"></td>`;

  id.value="";
  prenom.value="";
  document.getElementById("input-nom").value="";
  btnAjouter.disabled=true;
  statutForm.style.backgroundColor="red";
}


for(balise of document.querySelectorAll(".input-tab"))
{
  balise.onkeyup=verifsInput;
}

function verifsInput(event)
{
  let id = document.getElementById("input-id").value;
  let prenom =  document.getElementById("input-prenom").value;
  let nom =  document.getElementById("input-nom").value;

  if(id!="" && prenom!="" && nom!="")
  {
    btnAjouter.disabled=false;
    statutForm.style.backgroundColor="green";
    if(event.key=="Enter")
    {
      ajouterTableau();
    }
  }
  else
  {
    btnAjouter.disabled=true;
    statutForm.style.backgroundColor="red";
  }
}

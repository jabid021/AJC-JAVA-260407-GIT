
  let minute=0;
  let seconde=0;

  let monInterval;

  btnStart.onclick=function()
  {
    monInterval=setInterval(calculTime,1000);
    btnStart.disabled=true;
    btnStop.disabled=false;
  };

  btnStop.onclick=function()
  {
    clearInterval(monInterval);
    btnStart.disabled=false;
    btnStop.disabled=true;
  }


  btnReset.onclick=function()
  {
    minute=0;
    seconde=0;
    majAffichage();
  }
  function calculTime()
  {
    seconde++;
    if(seconde==60)
    {
      seconde=0;
      minute++;
      if(minute==60)
      {
        minute=0;
      }
    }
    majAffichage();
  }

  function majAffichage()
  {
    let minuteAffiche = (minute<10) ? "0"+minute : ""+minute;
    chrono.innerHTML=minuteAffiche+":"+seconde.toString().padStart(2,"0");
  }

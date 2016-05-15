# PrintScreen
Um pequeno robo para tirar printscreen (screenlogger) em java
A aplicação simplesmente gera prints e salva na pasta /PrintScreen/ a cada 60,000ms a partir da raiz do disco de onde a aplicação está sendo executada. 
  
 Parâmetros:
  		
  			-p /folder/newFolder -d 5325
  
  -p 		usado para definir uma árvore de diretório personalizada para as imagens salvas.
  			Ex:
 
  			-p /Documentos/salvas/ 
 
  			Este argumento fará as capturas serem salvas a partir da raiz do disco na
  			seguinte árvore: c:\Documentos\salvas\PrinsScreen\
  
  -d		usado para definir o delay, tempo de espera, entre uma foto e outra. o padrão é 10,000ms 
  
			Ex: 
  	
 				-d 20000
 		
		  	Fará a aplicação ter um delay de 20,000ms a cada foto tirada.

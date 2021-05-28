call MRMistd.bat
call MRMgetpeak.bat
call MRMcorrect.bat
java -jar Runner.jar
"C:\Program Files\R\R-4.0.3\bin\Rscript.exe" MRMionc.r
call MRM_RT.bat
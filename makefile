
##
# 
# Sun Apr 19 20:55:35 BRT 2015
# author: Joao Gustavo Cabral de Marins
# e-mail: jgcmarins@gmail.com
# 
##

all: clean compileserver compileclient jarserver jarclient
clean:
	rm -rf clientside
	mkdir clientside
	rm -rf buildserver
	mkdir buildserver
	rm -rf buildclient
	mkdir buildclient
	rm -rf package
	mkdir package
compileserver:
	javac -cp buildserver src/image/transfer/server/*.java -d buildserver
compileclient:
	javac -cp buildclient src/image/transfer/client/*.java -d buildclient
jarserver:
	echo "Main-Class: image.transfer.server.ImageTransferServer" > buildserver/manifest.txt
	jar cvfm package/image-transf-server.jar buildserver/manifest.txt -C buildserver .
jarclient:
	echo "Main-Class: image.transfer.client.ImageTransferClient" > buildclient/manifest.txt
	jar cvfm package/image-transf-client.jar buildclient/manifest.txt -C buildclient .
runserver:
	java -jar package/image-transf-server.jar
runclient:
	java -jar package/image-transf-client.jar

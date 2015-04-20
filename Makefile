
##
# 
# Sun Apr 19 20:55:35 BRT 2015
# author: Joao Gustavo Cabral de Marins
# e-mail: jgcmarins@gmail.com
# 
##

all: clean compile jarserver jarclient
clean:
	rm -rf build
	mkdir build
	rm -rf package
	mkdir package
compile:
	javac -cp build src/image/transfer/**/*.java -d build
jarserver:
	echo "Main-Class: image.transfer.server.ImageTransferServer" > build/manifest.txt
	jar cvfm package/image-transf-server.jar build/manifest.txt -C build .
jarclient:
	echo "Main-Class: image.transfer.client.ImageTransferClient" > build/manifest.txt
	jar cvfm package/image-transf-client.jar build/manifest.txt -C build .
runserver:
	java -jar package/image-transf-server.jar
runclient:
	java -jar package/image-transf-client.jar

gen:
	cd pb/proto && protoc -I=. --gogofaster_out=plugins=grpc:../protogo --gogofaster_opt=paths=source_relative dockervm_message.proto

mockgen:
	mockgen -destination ./sdk/mock_sdk_interface.go -package sdk -source ./sdk/sdk_interface.go

mockgen-dep:
	go get -u github.com/golang/mock/gomock
	go get -u github.com/golang/mock/mockgen
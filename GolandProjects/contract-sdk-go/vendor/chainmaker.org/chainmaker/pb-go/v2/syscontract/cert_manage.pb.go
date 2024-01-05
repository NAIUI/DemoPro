// Code generated by protoc-gen-gogo. DO NOT EDIT.
// source: syscontract/cert_manage.proto

package syscontract

import (
	fmt "fmt"
	proto "github.com/gogo/protobuf/proto"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.GoGoProtoPackageIsVersion3 // please upgrade the proto package

// methods of certificate management
type CertManageFunction int32

const (
	// add one certificate
	CertManageFunction_CERT_ADD CertManageFunction = 0
	// delete certificates
	CertManageFunction_CERTS_DELETE CertManageFunction = 1
	// query certificates
	CertManageFunction_CERTS_QUERY CertManageFunction = 2
	// freeze certificates
	CertManageFunction_CERTS_FREEZE CertManageFunction = 3
	// unfreeze certificates
	CertManageFunction_CERTS_UNFREEZE CertManageFunction = 4
	// revoke certificates
	CertManageFunction_CERTS_REVOKE CertManageFunction = 5
	// add one certificate alias, any
	CertManageFunction_CERT_ALIAS_ADD CertManageFunction = 6
	// update one certificate alias, self
	CertManageFunction_CERT_ALIAS_UPDATE CertManageFunction = 7
	// delete certificate alias, admin
	CertManageFunction_CERTS_ALIAS_DELETE CertManageFunction = 8
	// query certificate alias, admin
	CertManageFunction_CERTS_ALIAS_QUERY CertManageFunction = 9
)

var CertManageFunction_name = map[int32]string{
	0: "CERT_ADD",
	1: "CERTS_DELETE",
	2: "CERTS_QUERY",
	3: "CERTS_FREEZE",
	4: "CERTS_UNFREEZE",
	5: "CERTS_REVOKE",
	6: "CERT_ALIAS_ADD",
	7: "CERT_ALIAS_UPDATE",
	8: "CERTS_ALIAS_DELETE",
	9: "CERTS_ALIAS_QUERY",
}

var CertManageFunction_value = map[string]int32{
	"CERT_ADD":           0,
	"CERTS_DELETE":       1,
	"CERTS_QUERY":        2,
	"CERTS_FREEZE":       3,
	"CERTS_UNFREEZE":     4,
	"CERTS_REVOKE":       5,
	"CERT_ALIAS_ADD":     6,
	"CERT_ALIAS_UPDATE":  7,
	"CERTS_ALIAS_DELETE": 8,
	"CERTS_ALIAS_QUERY":  9,
}

func (x CertManageFunction) String() string {
	return proto.EnumName(CertManageFunction_name, int32(x))
}

func (CertManageFunction) EnumDescriptor() ([]byte, []int) {
	return fileDescriptor_66924a6b3678c62f, []int{0}
}

func init() {
	proto.RegisterEnum("syscontract.CertManageFunction", CertManageFunction_name, CertManageFunction_value)
}

func init() { proto.RegisterFile("syscontract/cert_manage.proto", fileDescriptor_66924a6b3678c62f) }

var fileDescriptor_66924a6b3678c62f = []byte{
	// 272 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x4c, 0x90, 0xcd, 0x4a, 0xc3, 0x40,
	0x14, 0x85, 0x13, 0x7f, 0x6a, 0x9d, 0x16, 0x1d, 0x2f, 0xe8, 0xae, 0xf3, 0x00, 0x82, 0x09, 0xe8,
	0x13, 0xc4, 0xe6, 0x16, 0xc4, 0xfa, 0x97, 0x26, 0x82, 0xdd, 0x84, 0x24, 0x84, 0x58, 0xa4, 0x33,
	0x61, 0x3a, 0x0a, 0xbe, 0x85, 0x8f, 0xe5, 0xb2, 0x3b, 0x5d, 0x4a, 0xf2, 0x22, 0xd2, 0x4c, 0x43,
	0x66, 0x79, 0xbf, 0xf3, 0x0d, 0x73, 0x38, 0x64, 0xb4, 0xfa, 0x5c, 0x65, 0x82, 0x2b, 0x99, 0x64,
	0xca, 0xcd, 0x72, 0xa9, 0xe2, 0x65, 0xc2, 0x93, 0x22, 0x77, 0x4a, 0x29, 0x94, 0x80, 0x81, 0x11,
	0x9f, 0xff, 0xd8, 0x04, 0xc6, 0xb9, 0x54, 0x77, 0x8d, 0x31, 0x79, 0xe7, 0x99, 0x5a, 0x08, 0x0e,
	0x43, 0xd2, 0x1f, 0x63, 0x10, 0xc6, 0x9e, 0xef, 0x53, 0x0b, 0x28, 0x19, 0x6e, 0xae, 0x59, 0xec,
	0xe3, 0x14, 0x43, 0xa4, 0x36, 0x1c, 0x93, 0x81, 0x26, 0x4f, 0x11, 0x06, 0x2f, 0x74, 0xa7, 0x53,
	0x26, 0x01, 0xe2, 0x1c, 0xe9, 0x2e, 0x00, 0x39, 0xd2, 0x24, 0xba, 0xdf, 0xb2, 0xbd, 0xce, 0x0a,
	0xf0, 0xf9, 0xe1, 0x16, 0xe9, 0x7e, 0x6b, 0xc5, 0xde, 0xf4, 0xc6, 0x9b, 0x35, 0xdf, 0xf5, 0xe0,
	0x94, 0x9c, 0x18, 0x2c, 0x7a, 0xf4, 0xbd, 0x10, 0xe9, 0x01, 0x9c, 0x11, 0xd0, 0x8f, 0x35, 0xdf,
	0x76, 0xe9, 0xb7, 0x7a, 0xcb, 0x75, 0xa3, 0xc3, 0xeb, 0xe2, 0xbb, 0x62, 0xf6, 0xba, 0x62, 0xf6,
	0x5f, 0xc5, 0xec, 0xaf, 0x9a, 0x59, 0xeb, 0x9a, 0x59, 0xbf, 0x35, 0xb3, 0xc8, 0x48, 0xc8, 0xc2,
	0xc9, 0x5e, 0x93, 0x05, 0x5f, 0x26, 0x6f, 0xb9, 0x74, 0xca, 0xd4, 0x31, 0x26, 0x99, 0x9b, 0x91,
	0x90, 0x85, 0xdb, 0x9d, 0x6e, 0x99, 0x5e, 0x14, 0xc2, 0xfd, 0xb8, 0x74, 0x0d, 0x3f, 0xed, 0x35,
	0xb3, 0x5e, 0xfd, 0x07, 0x00, 0x00, 0xff, 0xff, 0xe8, 0x3e, 0xf4, 0x96, 0x77, 0x01, 0x00, 0x00,
}
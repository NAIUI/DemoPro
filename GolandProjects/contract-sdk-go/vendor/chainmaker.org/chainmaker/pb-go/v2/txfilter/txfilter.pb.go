// Code generated by protoc-gen-gogo. DO NOT EDIT.
// source: txfilter/txfilter.proto

// TODO V2.4.0, migrates other tx filter related objects to the current package

package txfilter

import (
	fmt "fmt"
	proto "github.com/gogo/protobuf/proto"
	io "io"
	math "math"
	math_bits "math/bits"
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

// Stat contains stat
type Stat struct {
	// A value greater than 0 indicates a false positive in the tx filter, support for multiple transactions in the future
	FpCount uint32 `protobuf:"varint,1,opt,name=fp_count,json=fpCount,proto3" json:"fp_count,omitempty"`
	// Filter query time
	FilterCosts int64 `protobuf:"varint,2,opt,name=filter_costs,json=filterCosts,proto3" json:"filter_costs,omitempty"`
	// DB query time
	DbCosts int64 `protobuf:"varint,3,opt,name=db_costs,json=dbCosts,proto3" json:"db_costs,omitempty"`
}

func (m *Stat) Reset()         { *m = Stat{} }
func (m *Stat) String() string { return proto.CompactTextString(m) }
func (*Stat) ProtoMessage()    {}
func (*Stat) Descriptor() ([]byte, []int) {
	return fileDescriptor_6dcec2a32104aa33, []int{0}
}
func (m *Stat) XXX_Unmarshal(b []byte) error {
	return m.Unmarshal(b)
}
func (m *Stat) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	if deterministic {
		return xxx_messageInfo_Stat.Marshal(b, m, deterministic)
	} else {
		b = b[:cap(b)]
		n, err := m.MarshalToSizedBuffer(b)
		if err != nil {
			return nil, err
		}
		return b[:n], nil
	}
}
func (m *Stat) XXX_Merge(src proto.Message) {
	xxx_messageInfo_Stat.Merge(m, src)
}
func (m *Stat) XXX_Size() int {
	return m.Size()
}
func (m *Stat) XXX_DiscardUnknown() {
	xxx_messageInfo_Stat.DiscardUnknown(m)
}

var xxx_messageInfo_Stat proto.InternalMessageInfo

func (m *Stat) GetFpCount() uint32 {
	if m != nil {
		return m.FpCount
	}
	return 0
}

func (m *Stat) GetFilterCosts() int64 {
	if m != nil {
		return m.FilterCosts
	}
	return 0
}

func (m *Stat) GetDbCosts() int64 {
	if m != nil {
		return m.DbCosts
	}
	return 0
}

func init() {
	proto.RegisterType((*Stat)(nil), "txfilter.Stat")
}

func init() { proto.RegisterFile("txfilter/txfilter.proto", fileDescriptor_6dcec2a32104aa33) }

var fileDescriptor_6dcec2a32104aa33 = []byte{
	// 180 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0xe2, 0x12, 0x2f, 0xa9, 0x48, 0xcb,
	0xcc, 0x29, 0x49, 0x2d, 0xd2, 0x87, 0x31, 0xf4, 0x0a, 0x8a, 0xf2, 0x4b, 0xf2, 0x85, 0x38, 0x60,
	0x7c, 0xa5, 0x78, 0x2e, 0x96, 0xe0, 0x92, 0xc4, 0x12, 0x21, 0x49, 0x2e, 0x8e, 0xb4, 0x82, 0xf8,
	0xe4, 0xfc, 0xd2, 0xbc, 0x12, 0x09, 0x46, 0x05, 0x46, 0x0d, 0xde, 0x20, 0xf6, 0xb4, 0x02, 0x67,
	0x10, 0x57, 0x48, 0x91, 0x8b, 0x07, 0xa2, 0x38, 0x3e, 0x39, 0xbf, 0xb8, 0xa4, 0x58, 0x82, 0x49,
	0x81, 0x51, 0x83, 0x39, 0x88, 0x1b, 0x22, 0xe6, 0x0c, 0x12, 0x02, 0xe9, 0x4e, 0x49, 0x82, 0x4a,
	0x33, 0x83, 0xa5, 0xd9, 0x53, 0x92, 0xc0, 0x52, 0x4e, 0xae, 0x27, 0x1e, 0xc9, 0x31, 0x5e, 0x78,
	0x24, 0xc7, 0xf8, 0xe0, 0x91, 0x1c, 0xe3, 0x84, 0xc7, 0x72, 0x0c, 0x17, 0x1e, 0xcb, 0x31, 0xdc,
	0x78, 0x2c, 0xc7, 0x10, 0xa5, 0x9d, 0x9c, 0x91, 0x98, 0x99, 0x97, 0x9b, 0x98, 0x9d, 0x5a, 0xa4,
	0x97, 0x5f, 0x94, 0xae, 0x8f, 0xe0, 0xea, 0x17, 0x24, 0xe9, 0xa6, 0xe7, 0xeb, 0x97, 0x19, 0xc1,
	0xdd, 0x9d, 0xc4, 0x06, 0x76, 0xb8, 0x31, 0x20, 0x00, 0x00, 0xff, 0xff, 0xb0, 0x17, 0xe2, 0x5a,
	0xd3, 0x00, 0x00, 0x00,
}

func (m *Stat) Marshal() (dAtA []byte, err error) {
	size := m.Size()
	dAtA = make([]byte, size)
	n, err := m.MarshalToSizedBuffer(dAtA[:size])
	if err != nil {
		return nil, err
	}
	return dAtA[:n], nil
}

func (m *Stat) MarshalTo(dAtA []byte) (int, error) {
	size := m.Size()
	return m.MarshalToSizedBuffer(dAtA[:size])
}

func (m *Stat) MarshalToSizedBuffer(dAtA []byte) (int, error) {
	i := len(dAtA)
	_ = i
	var l int
	_ = l
	if m.DbCosts != 0 {
		i = encodeVarintTxfilter(dAtA, i, uint64(m.DbCosts))
		i--
		dAtA[i] = 0x18
	}
	if m.FilterCosts != 0 {
		i = encodeVarintTxfilter(dAtA, i, uint64(m.FilterCosts))
		i--
		dAtA[i] = 0x10
	}
	if m.FpCount != 0 {
		i = encodeVarintTxfilter(dAtA, i, uint64(m.FpCount))
		i--
		dAtA[i] = 0x8
	}
	return len(dAtA) - i, nil
}

func encodeVarintTxfilter(dAtA []byte, offset int, v uint64) int {
	offset -= sovTxfilter(v)
	base := offset
	for v >= 1<<7 {
		dAtA[offset] = uint8(v&0x7f | 0x80)
		v >>= 7
		offset++
	}
	dAtA[offset] = uint8(v)
	return base
}
func (m *Stat) Size() (n int) {
	if m == nil {
		return 0
	}
	var l int
	_ = l
	if m.FpCount != 0 {
		n += 1 + sovTxfilter(uint64(m.FpCount))
	}
	if m.FilterCosts != 0 {
		n += 1 + sovTxfilter(uint64(m.FilterCosts))
	}
	if m.DbCosts != 0 {
		n += 1 + sovTxfilter(uint64(m.DbCosts))
	}
	return n
}

func sovTxfilter(x uint64) (n int) {
	return (math_bits.Len64(x|1) + 6) / 7
}
func sozTxfilter(x uint64) (n int) {
	return sovTxfilter(uint64((x << 1) ^ uint64((int64(x) >> 63))))
}
func (m *Stat) Unmarshal(dAtA []byte) error {
	l := len(dAtA)
	iNdEx := 0
	for iNdEx < l {
		preIndex := iNdEx
		var wire uint64
		for shift := uint(0); ; shift += 7 {
			if shift >= 64 {
				return ErrIntOverflowTxfilter
			}
			if iNdEx >= l {
				return io.ErrUnexpectedEOF
			}
			b := dAtA[iNdEx]
			iNdEx++
			wire |= uint64(b&0x7F) << shift
			if b < 0x80 {
				break
			}
		}
		fieldNum := int32(wire >> 3)
		wireType := int(wire & 0x7)
		if wireType == 4 {
			return fmt.Errorf("proto: Stat: wiretype end group for non-group")
		}
		if fieldNum <= 0 {
			return fmt.Errorf("proto: Stat: illegal tag %d (wire type %d)", fieldNum, wire)
		}
		switch fieldNum {
		case 1:
			if wireType != 0 {
				return fmt.Errorf("proto: wrong wireType = %d for field FpCount", wireType)
			}
			m.FpCount = 0
			for shift := uint(0); ; shift += 7 {
				if shift >= 64 {
					return ErrIntOverflowTxfilter
				}
				if iNdEx >= l {
					return io.ErrUnexpectedEOF
				}
				b := dAtA[iNdEx]
				iNdEx++
				m.FpCount |= uint32(b&0x7F) << shift
				if b < 0x80 {
					break
				}
			}
		case 2:
			if wireType != 0 {
				return fmt.Errorf("proto: wrong wireType = %d for field FilterCosts", wireType)
			}
			m.FilterCosts = 0
			for shift := uint(0); ; shift += 7 {
				if shift >= 64 {
					return ErrIntOverflowTxfilter
				}
				if iNdEx >= l {
					return io.ErrUnexpectedEOF
				}
				b := dAtA[iNdEx]
				iNdEx++
				m.FilterCosts |= int64(b&0x7F) << shift
				if b < 0x80 {
					break
				}
			}
		case 3:
			if wireType != 0 {
				return fmt.Errorf("proto: wrong wireType = %d for field DbCosts", wireType)
			}
			m.DbCosts = 0
			for shift := uint(0); ; shift += 7 {
				if shift >= 64 {
					return ErrIntOverflowTxfilter
				}
				if iNdEx >= l {
					return io.ErrUnexpectedEOF
				}
				b := dAtA[iNdEx]
				iNdEx++
				m.DbCosts |= int64(b&0x7F) << shift
				if b < 0x80 {
					break
				}
			}
		default:
			iNdEx = preIndex
			skippy, err := skipTxfilter(dAtA[iNdEx:])
			if err != nil {
				return err
			}
			if (skippy < 0) || (iNdEx+skippy) < 0 {
				return ErrInvalidLengthTxfilter
			}
			if (iNdEx + skippy) > l {
				return io.ErrUnexpectedEOF
			}
			iNdEx += skippy
		}
	}

	if iNdEx > l {
		return io.ErrUnexpectedEOF
	}
	return nil
}
func skipTxfilter(dAtA []byte) (n int, err error) {
	l := len(dAtA)
	iNdEx := 0
	depth := 0
	for iNdEx < l {
		var wire uint64
		for shift := uint(0); ; shift += 7 {
			if shift >= 64 {
				return 0, ErrIntOverflowTxfilter
			}
			if iNdEx >= l {
				return 0, io.ErrUnexpectedEOF
			}
			b := dAtA[iNdEx]
			iNdEx++
			wire |= (uint64(b) & 0x7F) << shift
			if b < 0x80 {
				break
			}
		}
		wireType := int(wire & 0x7)
		switch wireType {
		case 0:
			for shift := uint(0); ; shift += 7 {
				if shift >= 64 {
					return 0, ErrIntOverflowTxfilter
				}
				if iNdEx >= l {
					return 0, io.ErrUnexpectedEOF
				}
				iNdEx++
				if dAtA[iNdEx-1] < 0x80 {
					break
				}
			}
		case 1:
			iNdEx += 8
		case 2:
			var length int
			for shift := uint(0); ; shift += 7 {
				if shift >= 64 {
					return 0, ErrIntOverflowTxfilter
				}
				if iNdEx >= l {
					return 0, io.ErrUnexpectedEOF
				}
				b := dAtA[iNdEx]
				iNdEx++
				length |= (int(b) & 0x7F) << shift
				if b < 0x80 {
					break
				}
			}
			if length < 0 {
				return 0, ErrInvalidLengthTxfilter
			}
			iNdEx += length
		case 3:
			depth++
		case 4:
			if depth == 0 {
				return 0, ErrUnexpectedEndOfGroupTxfilter
			}
			depth--
		case 5:
			iNdEx += 4
		default:
			return 0, fmt.Errorf("proto: illegal wireType %d", wireType)
		}
		if iNdEx < 0 {
			return 0, ErrInvalidLengthTxfilter
		}
		if depth == 0 {
			return iNdEx, nil
		}
	}
	return 0, io.ErrUnexpectedEOF
}

var (
	ErrInvalidLengthTxfilter        = fmt.Errorf("proto: negative length found during unmarshaling")
	ErrIntOverflowTxfilter          = fmt.Errorf("proto: integer overflow")
	ErrUnexpectedEndOfGroupTxfilter = fmt.Errorf("proto: unexpected end of group")
)

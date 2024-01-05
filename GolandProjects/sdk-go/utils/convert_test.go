/*
Copyright (C) BABEC. All rights reserved.
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/
package utils

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestU64ToBytes(t *testing.T) {
	var tests = []struct {
		in   uint64
		want []byte
	}{
		{0, []byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}},
		{1, []byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}},
		{123456, []byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0}},
	}

	for _, tt := range tests {
		testname := fmt.Sprintf("%d", tt.in)
		t.Run(testname, func(t *testing.T) {
			out := U64ToBytes(tt.in)
			require.Equal(t, tt.want, out)
		})
	}
}

func TestBytesToU64(t *testing.T) {
	var tests = []struct {
		in        []byte
		want      uint64
		expectErr bool
	}{
		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 0, false},
		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x01}, 0, true},
		{[]byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 1, false},
		{[]byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x02}, 0, true},
		{[]byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0}, 123456, false},
		{[]byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x01, 0x02}, 0, true},

		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 0, true},
		{[]byte{0x40, 0xe2, 0x1}, 0, true},
		{[]byte{}, 0, true},
		{nil, 0, true},
	}

	for _, tt := range tests {
		testname := fmt.Sprintf("%d", tt.in)
		t.Run(testname, func(t *testing.T) {
			out, err := BytesToU64(tt.in)
			require.Equal(t, err != nil, tt.expectErr)
			require.Equal(t, tt.want, out)
		})
	}
}

func TestI64ToBytes(t *testing.T) {
	var tests = []struct {
		in   int64
		want []byte
	}{
		{0, []byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}},
		{1, []byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}},
		{123456, []byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0}},
	}

	for _, tt := range tests {
		testname := fmt.Sprintf("%d", tt.in)
		t.Run(testname, func(t *testing.T) {
			out := I64ToBytes(tt.in)
			require.Equal(t, tt.want, out)
		})
	}
}

func TestBytesToI64(t *testing.T) {
	var tests = []struct {
		in        []byte
		want      int64
		expectErr bool
	}{
		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 0, false},
		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x01}, 0, true},
		{[]byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 1, false},
		{[]byte{0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x02}, 0, true},
		{[]byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0}, 123456, false},
		{[]byte{0x40, 0xe2, 0x1, 0x0, 0x0, 0x0, 0x0, 0x0, 0x01, 0x02}, 0, true},

		{[]byte{0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0}, 0, true},
		{[]byte{0x40, 0xe2, 0x1}, 0, true},
		{[]byte{}, 0, true},
		{nil, 0, true},
	}

	for _, tt := range tests {
		testname := fmt.Sprintf("%d", tt.in)
		t.Run(testname, func(t *testing.T) {
			out, err := BytesToI64(tt.in)
			require.Equal(t, err != nil, tt.expectErr)
			require.Equal(t, tt.want, out)
		})
	}
}

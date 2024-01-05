/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package chainmaker_sdk_go

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestCheckNewBlockChainConfig(t *testing.T) {
	tests := []struct {
		name string
	}{
		{
			"good",
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			cli, err := newMockChainClient(nil, nil, WithConfPath(sdkConfigPathForUT))
			require.Nil(t, err)
			defer cli.Stop()

			err = cli.CheckNewBlockChainConfig()
			require.Nil(t, err)
		})
	}
}

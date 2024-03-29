package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_buildTree(t *testing.T) {
	type args struct {
		preorder []int
		inorder  []int
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "test",
			args: args{preorder: []int{3, 9, 20, 15, 7}, inorder: []int{9, 3, 15, 20, 7}},
			want: structures.Ints2TreeNode([]int{3, 9, 20, structures.NULL, structures.NULL, 15, 7}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := buildTree(tt.args.preorder, tt.args.inorder); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("buildTree() = %v, want %v", got, tt.want)
			}
		})
	}
}

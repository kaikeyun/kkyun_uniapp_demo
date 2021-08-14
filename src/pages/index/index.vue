<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view>
			<text class="title">{{title}}</text>
		</view>
		<button class="button" @click="onOpenRoom()">进入教室</button>
		<button class="button" @click="onOpenPlay()">播放回放</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello kkyun_sdk'
			}
		},
		onLoad() {

		},
		methods: {
            onOpenRoom() {
                const KKSDK = uni.requireNativePlugin('KKSDK');
                uni.request({
                    url: 'http://192.168.0.100:10008/joinroom',
                    success: (res) => {
                      var json = res.data;
                      console.warn('joinroom:', json);
                      KKSDK.openRoom(json.data.roomid, json.data.userid, json.data.token);
                    }
                });
            },
            onOpenPlay() {
                const KKSDK = uni.requireNativePlugin('KKSDK');
                uni.request({
                    url: 'http://192.168.0.100:10008/getrecord',
                    success: (res) => {
                      var json = res.data;
                      console.warn('getreocrd:', json);
                      KKSDK.openPlay(json.data.recid, json.data.userid, json.data.token);
                    }
                });
            }
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin: 200rpx auto 50rpx auto;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}

	.button{
		font-size: 36rpx;
		color: #8f8f94;
		margin-top: 40rpx;
	}
</style>

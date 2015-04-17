package com.xiaoerge.filecloud.server.model;

import com.jcraft.jsch.*;

import javax.crypto.*;
import javax.crypto.Cipher;
import java.security.*;
import java.security.KeyPair;

/**
 * Created by xiaoerge on 4/17/15.
 */
public class ChannelSession
{
    private static ChannelSession channelSession = new ChannelSession();
    private JSch jsch;
    private Session session;
    private Channel channel;
    private ChannelSftp channelsftp;
    private UserInfo accountinfo;

    private KeyPairGenerator keyGen;
    private java.security.KeyPair key;
    private javax.crypto.Cipher cipher;

    private ChannelSession() {
        jsch = new JSch();
        session = null;
        accountinfo = null;
        channel = null;
        keyGen = null;
        key = null;
        cipher = null;
    }

    public static ChannelSession getInstance() {
        if (channelSession == null)
            return new ChannelSession();
        return channelSession;
    }

    public JSch getJsch() {
        return jsch;
    }

    public void setJsch(JSch jsch) {
        this.jsch = jsch;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ChannelSftp getChannelsftp() {
        return channelsftp;
    }

    public void setChannelsftp(ChannelSftp channelsftp) {
        this.channelsftp = channelsftp;
    }

    public UserInfo getAccountinfo() {
        return accountinfo;
    }

    public void setAccountinfo(UserInfo accountinfo) {
        this.accountinfo = accountinfo;
    }

    public KeyPairGenerator getKeyGen() {
        return keyGen;
    }

    public void setKeyGen(KeyPairGenerator keyGen) {
        this.keyGen = keyGen;
    }

    public KeyPair getKey() {
        return key;
    }

    public void setKey(KeyPair key) {
        this.key = key;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }
}

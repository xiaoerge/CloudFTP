package com.xiaoerge.cloudftp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("authservice")
public interface AuthService extends RemoteService {

    public byte[] authenticate(String host, byte[] passwd, int port);
    public byte[] authenticateSession();
}

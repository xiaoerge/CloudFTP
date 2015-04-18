package com.xiaoerge.filecloud.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.xiaoerge.filecloud.client.ShellService;
import com.xiaoerge.filecloud.client.model.FileEntry;
import com.xiaoerge.filecloud.server.model.ClientSession;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xiaoerge on 4/17/15.
 */
public class ShellServiceImpl extends RemoteServiceServlet implements ShellService {

    private static Logger logger = Logger.getLogger(ShellServiceImpl.class.getName());

    @Override
    public Vector<FileEntry> ls(String path) {
        ClientSession clientSession = ClientSession.getInstance();
        ChannelSftp channelSftp = clientSession.getChannelsftp();

        try {
            Vector<ChannelSftp.LsEntry> lsEntries = channelSftp.ls(path);
            Vector<FileEntry> entries = new Vector<>();
            for (int i = 0; i < lsEntries.size(); i++)
            {
                String fileName = lsEntries.get(i).getFilename();

                //hiddne file
                if (fileName.startsWith(".")) {
                    continue;
                }

                FileEntry fileEntry = new FileEntry();
                fileEntry.setFileName(fileName);
                entries.add(fileEntry);
            }
            return entries;
        } catch (SftpException e) {
            e.printStackTrace();
            return null;
        }
    }
}

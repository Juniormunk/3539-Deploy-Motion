package com.bytingbuilldogs.motiondeploy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPUploader
{
	JSch jsch = new JSch();
	Session session = null;
	ChannelSftp sftpChannel;
	Channel channel;

	SFTPUploader(String username, String password, String host, int port)
	{
		try
		{
			session = jsch.getSession(username, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();

			channel = session.openChannel("sftp");
			sftpChannel = (ChannelSftp) channel;

		}
		catch (JSchException e)
		{
			e.printStackTrace();
		}
	}

	public void putArray(List<File> files, String directory) throws FileNotFoundException, SftpException
	{
		for (File file : files)
		{
			InputStream targetStream = new FileInputStream(file);
			sftpChannel.put(targetStream, directory);
		}
	}

	public void connect() throws JSchException
	{
		session.connect();
	}

	public void disconnect()
	{
		session.disconnect();
	}

}
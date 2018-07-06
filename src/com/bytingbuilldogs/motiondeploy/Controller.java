package com.bytingbuilldogs.motiondeploy;

import java.io.FileNotFoundException;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller
{

	@FXML
	private Button button;
	@FXML
	public void click()
	{
		{
			System.out.println("HIS");
			try
			{
				SFTPUploader uploader = new SFTPUploader("lvuser", "", "10.35.39.2", 22);
				uploader.connect();
				uploader.putArray(Main.files, "logs");
				uploader.disconnect();
			}
			catch (JSchException | FileNotFoundException | SftpException e1)
			{
				e1.printStackTrace();
			}

		}
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import sbb.model.Settings;

/**
 *
 * @author Antonio
 */
public class IOHandler {

    private static final Charset DEFAUL_CHARSET = Charset.forName("UTF-8");
    private final File sourceFile;
    private String jsonData;

    public IOHandler(File file) {
	this.sourceFile = file;
    }

    private void loadData() {
	try (InputStream is = Files.newInputStream(sourceFile.toPath(), StandardOpenOption.READ);
		JsonReader rdr = Json.createReader(is)) {

	    JsonObject jo = rdr.readObject();

	} catch (IOException ioe) {

	}
    }

    private Settings getSettings() {
	return new Settings();
    }

    private void saveData() {

    }
}

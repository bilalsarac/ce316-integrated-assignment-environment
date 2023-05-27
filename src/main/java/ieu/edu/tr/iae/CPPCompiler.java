package ieu.edu.tr.iae;

import java.io.*;

public class CPPCompiler extends Compiler {
    public static String compilerPath = "g++";
    public static String args = "main.cpp";

    public CPPCompiler(File workingDirectory) {
        super(workingDirectory);
    }

    @Override
    public Output compile(String path, String args) throws Exception {
        String command = compilerPath + " " + args + " -o output";

        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(workingDirectory);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        String output = readProcessOutput(process.getInputStream());

        int exitCode = process.waitFor();

        return new Output(exitCode,  null, output);
    }

    private String readProcessOutput(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        return output.toString();
    }
}


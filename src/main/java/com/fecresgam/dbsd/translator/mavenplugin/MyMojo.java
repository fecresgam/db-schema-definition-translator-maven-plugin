/* **********************************************************************
 *   This file is part of DB Schema Definition Translator.              *
 *                                                                      *
 *   DB Schema Definition Translator is free software: you can          *
 *   redistribute it and/or modify it under the terms of the GNU        *
 *   General Public License as published by the Free Software           *
 *   Foundation, either version 2 of the License, or any later version. *
 *                                                                      *
 *   Foobar is distributed in the hope that it will be useful,          *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of     *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the      *
 *   GNU General Public License for more details.                       *
 *                                                                      *
 *   You should have received a copy of the GNU General Public License  *
 *   along with Foobar.  If not, see <http://www.gnu.org/licenses/>.    *
 *                                                                      *
 *   Author: Felipe Crespo Gambade                                      *
 *                                                                      *
 ************************************************************************/

package com.fecresgam.dbsd.translator.mavenplugin;

import com.fecresgam.dbsd.translator.DbsdConversor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Launches DSBD.
 * @see https://github.com/fecresgam/db-schema-definition-translator
 */
@Mojo( name = "translate")
@Execute(phase = LifecyclePhase.PROCESS_RESOURCES)

public class MyMojo
    extends AbstractMojo
{

    private static final String OUPTUP_FORMAT_FLAG = "-o";
    @Parameter
    private String outputFormat;
    @Parameter(required=true)
    private String inputFileName;
    @Parameter
    private String outputFolder;
    @Parameter(required=true)
    private String outputFilePrefix;



    public void execute()
        throws MojoExecutionException
    {

        getLog().info("Translating " + inputFileName +
                              " to '" + outputFormat +"' file(s): " +
                              outputFolder+ outputFilePrefix + "-XXXXXX." + outputFormat );

        final String[] args =
                convertToArray(
                        OUPTUP_FORMAT_FLAG,
                        outputFormat,
                        inputFileName,
                        outputFolder,
                        outputFilePrefix);

        DbsdConversor.main(args);

    }

    private String[] convertToArray(final String ... args)
    {
        String[] result = new String[args.length];
        System.arraycopy(args, 0, result, 0, args.length);

        return result;
    }
}

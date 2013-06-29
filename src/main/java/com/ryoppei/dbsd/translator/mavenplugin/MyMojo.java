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

package com.ryoppei.dbsd.translator.mavenplugin;

import com.ryoppei.dbsd.translator.DbsdConversor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which touches a timestamp file.
 *
 * @goal translate
 * 
 * @phase process-sources
 */
public class MyMojo
    extends AbstractMojo
{

    /**
     * @parameter
     */
    private String outputFormat;
    /**
     * @parameter
     */
    private String inputFileName;
    /**
     * @parameter
     */
    private String outputFolder;
    /**
     * @parameter
     */
    private String outputFilePrefix;



    public void execute()
        throws MojoExecutionException
    {


        final String[] args = convertToArray(outputFormat, inputFileName, outputFolder, outputFilePrefix);
        DbsdConversor.main(args);

        getLog().info("!!!!!!!!!!!!"+ outputFormat +"\n^^^^" + inputFileName+"\n++++++" + outputFolder+"\n,,,,," + outputFilePrefix + "...............hello world");

    }

    private String[] convertToArray(final String ... args)
    {
        String[] result = new String[args.length];
        System.arraycopy(args, 0, result, 0, args.length);

        return result;
    }
}

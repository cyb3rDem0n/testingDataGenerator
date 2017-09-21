package it.senseisrl.mitiga.survey.util;

	import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

	public class GzipDecode {

		public static String decompress(final byte[] compressed) throws IOException {
			String outStr = "";
			if ((compressed == null) || (compressed.length == 0)) {
				System.out.println("-----------------------------FORSE NULL o Zero Value-------------------------");
				return "";
			}
			if (isCompressed(compressed)) {
				GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8));
				
				String line;
				System.out.println("-----------------------------DECOMPRESSO OK-------------------------");
				while ((line = bufferedReader.readLine()) != null) {
					outStr += line;
				}
			} else {
				System.out.println("-----------------------------NESSUNA DECOMPRESSIONE-------------------------");
				outStr = new String(" ");
			}
			
			//gis.close();
			//bufferedReader.close();
			
			return outStr;
		}

		public static boolean isCompressed(final byte[] compressed) {
			return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC))
					&& (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
		}

	}
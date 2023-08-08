
//Alec Howard
//SID: 1555155
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SortDriver {

	/*
	 * Main generates 10 different data sets of random number between 1-1000 for
	 * each problem size: 100, 1000, 10000 runs each set of each problem size
	 * through 6 different sorting algorithms and gathers the runtimes calculates
	 * average and standard deviations of the run times gathers t-values between
	 * each of the different sorting algorithms
	 */

	public static void main(String args[]) {

		int arraySizes[] = { 100, 1000, 10000 };
		int nIterations = 10;

		ArrayList<Long> runTimesBub = new ArrayList<Long>();
		long avgRunTimesBub[] = new long[arraySizes.length];

		ArrayList<Long> runTimesIns = new ArrayList<Long>();
		long avgRunTimesIns[] = new long[arraySizes.length];

		ArrayList<Long> runTimesMer = new ArrayList<Long>();
		long avgRunTimesMer[] = new long[arraySizes.length];

		ArrayList<Long> runTimesRad = new ArrayList<Long>();
		long avgRunTimesRad[] = new long[arraySizes.length];

		ArrayList<Long> runTimesSel = new ArrayList<Long>();
		long avgRunTimesSel[] = new long[arraySizes.length];

		ArrayList<Long> runTimesQui = new ArrayList<Long>();
		long avgRunTimesQui[] = new long[arraySizes.length];

		Random randomNumberGenerator = new Random(1001);
		for (int i = 0; i < arraySizes.length; i++) {
			int iSize = arraySizes[i];
			Integer arrayOrig[][] = new Integer[1000][iSize];
			for (int k = 0; k < nIterations; k++) {
				for (int idx = 0; idx < iSize; idx++) {
					arrayOrig[k][idx] = randomNumberGenerator.nextInt(1000);
				}

				Integer arrayCopy1[] = new Integer[iSize];
				Integer arrayCopy2[] = new Integer[iSize];
				Integer arrayCopy3[] = new Integer[iSize];
				Integer arrayCopy4[] = new Integer[iSize];
				Integer arrayCopy5[] = new Integer[iSize];
				Integer arrayCopy6[] = new Integer[iSize];
				for (int idx = 0; idx < iSize; idx++) {
					arrayCopy1[idx] = arrayOrig[k][idx];
					arrayCopy2[idx] = arrayOrig[k][idx];
					arrayCopy3[idx] = arrayOrig[k][idx];
					arrayCopy4[idx] = arrayOrig[k][idx];
					arrayCopy5[idx] = arrayOrig[k][idx];
					arrayCopy6[idx] = arrayOrig[k][idx];

				}
				// Calculate bubbleSort run time

				long startTime1 = System.nanoTime();
				Sorting sortBubble = new Sorting();
				sortBubble.bubbleSort(arrayCopy1, arrayCopy1.length - 1);
				runTimesBub.add(System.nanoTime() - startTime1);
				avgRunTimesBub[i] += System.nanoTime() - startTime1;

				// Calculate InsertionSort run time

				long startTime2 = System.nanoTime();
				Sorting sortInsert = new Sorting();
				sortInsert.insertionSort(arrayCopy2, arrayCopy2.length - 1);
				runTimesIns.add(System.nanoTime() - startTime2);
				avgRunTimesIns[i] += System.nanoTime() - startTime2;
				// Calculate mergeSort run time

				long startTime3 = System.nanoTime();
				Sorting sortMerge = new Sorting();
				sortMerge.mergeSort(arrayCopy3, 0, arrayCopy3.length - 1);
				runTimesMer.add(System.nanoTime() - startTime3);
				avgRunTimesMer[i] += System.nanoTime() - startTime3;
				// Calculate radixSort run time

				long startTime4 = System.nanoTime();
				Sorting sortRadix = new Sorting();
				sortRadix.radixSort(arrayCopy4, arrayCopy4.length - 1);
				runTimesRad.add(System.nanoTime() - startTime4);
				avgRunTimesRad[i] += System.nanoTime() - startTime4;
				// Calculate selectionSort run time

				long startTime5 = System.nanoTime();
				Sorting sortSelection = new Sorting();
				sortSelection.selectionSort(arrayCopy5, arrayCopy5.length - 1);
				runTimesSel.add(System.nanoTime() - startTime5);
				avgRunTimesSel[i] += System.nanoTime() - startTime5;
				// Calculate quickSort run time

				long startTime6 = System.nanoTime();
				Sorting sortQuick = new Sorting();
				sortQuick.quickSort(arrayCopy6, 0, arrayCopy6.length - 1);
				runTimesQui.add(System.nanoTime() - startTime6);
				avgRunTimesQui[i] += System.nanoTime() - startTime6;

			}
			try {
				int m;
				long s;
				BufferedWriter writeToFile = new BufferedWriter(
						new FileWriter("C:\\Users\\Alecm\\eclipse-workspace\\P4\\src\\timings.dat", true));
				writeToFile.write("Set Size: " + iSize + "\n");
				writeToFile.write("SS ");
				// writeToFile.write(runTimesSel + " ");
				// Calc Avg

				writeToFile.write("Avg: " + avgRunTimesSel[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesSel.size(); m++) {
					s += Math.pow(runTimesSel.get(m) - (avgRunTimesSel[i] / nIterations), 2);
				}
				double selSd = Math.pow(s / (nIterations - 1), 0.5);

				writeToFile.write("SD: " + selSd);

				writeToFile.write("\n");
				writeToFile.write("BS ");
				// writeToFile.write(runTimesBub + " ");
				// Calc Avg
				writeToFile.write("Avg: " + avgRunTimesBub[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesBub.size(); m++) {
					s += Math.pow(runTimesBub.get(m) - (avgRunTimesBub[i] / nIterations), 2);
				}
				double bubSd = Math.pow(s / (nIterations - 1), 0.5);
				writeToFile.write("SD: " + bubSd);

				writeToFile.write("\n");
				writeToFile.write("IS ");
				// writeToFile.write(runTimesIns + " ");
				// Calc Avg
				writeToFile.write("Avg: " + avgRunTimesIns[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesIns.size(); m++) {
					s += Math.pow(runTimesIns.get(m) - (avgRunTimesIns[i] / nIterations), 2);
				}
				double insSd = Math.pow(s / (nIterations - 1), 0.5);

				writeToFile.write("SD: " + insSd);

				writeToFile.write("\n");
				writeToFile.write("MS ");
				// writeToFile.write(runTimesMer + " ");
				// Calc Avg
				writeToFile.write("Avg: " + avgRunTimesMer[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesMer.size(); m++) {
					s += Math.pow(runTimesMer.get(m) - (avgRunTimesMer[i] / nIterations), 2);
				}
				double merSd = Math.pow(s / (nIterations - 1), 0.5);

				writeToFile.write("SD: " + merSd);

				writeToFile.write("\n");
				writeToFile.write("QS ");
				// writeToFile.write(runTimesQui + " ");
				// Calc Avg
				writeToFile.write("Avg: " + avgRunTimesQui[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesQui.size(); m++) {
					s += Math.pow(runTimesQui.get(m) - (avgRunTimesQui[i] / nIterations), 2);
				}
				double quiSd = Math.pow(s / (nIterations - 1), 0.5);

				writeToFile.write("SD: " + quiSd);

				writeToFile.write("\n");
				writeToFile.write("RS ");
				// writeToFile.write(runTimesRad + " ");
				// Calc Avg
				writeToFile.write("Avg: " + avgRunTimesRad[i] / nIterations + " ");
				// Calc SD
				for (m = 0, s = 0; m < runTimesRad.size(); m++) {
					s += Math.pow(runTimesRad.get(m) - (avgRunTimesRad[i] / nIterations), 2);
				}
				double radSd = Math.pow(s / (nIterations - 1), 0.5);

				writeToFile.write("SD: " + radSd);

				writeToFile.write("\n");
				writeToFile.write("\n");

				// T-value Time!!
				double Tssbs = Math.abs(((avgRunTimesSel[i] / nIterations) - (avgRunTimesBub[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (selSd - bubSd));
				writeToFile.write("Tss,bs: " + Tssbs);
				writeToFile.write("\n");

				double Tssis = Math.abs(((avgRunTimesSel[i] / nIterations) - (avgRunTimesIns[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (selSd - insSd));
				writeToFile.write("Tss,is: " + Tssis);
				writeToFile.write("\n");

				double Tbsis = Math.abs(((avgRunTimesBub[i] / nIterations) - (avgRunTimesIns[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (bubSd - insSd));
				writeToFile.write("Tbs,is: " + Tbsis);
				writeToFile.write("\n");

				double Tssms = Math.abs(((avgRunTimesSel[i] / nIterations) - (avgRunTimesMer[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (selSd - merSd));
				writeToFile.write("Tss,ms: " + Tssms);
				writeToFile.write("\n");

				double Tbsms = Math.abs(((avgRunTimesBub[i] / nIterations) - (avgRunTimesMer[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (bubSd - merSd));
				writeToFile.write("Tbs,ms: " + Tbsms);
				writeToFile.write("\n");

				double Tisms = Math.abs(((avgRunTimesIns[i] / nIterations) - (avgRunTimesMer[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (insSd - merSd));
				writeToFile.write("Tis,ms: " + Tisms);
				writeToFile.write("\n");

				double Tssqs = Math.abs(((avgRunTimesSel[i] / nIterations) - (avgRunTimesQui[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (selSd - quiSd));
				writeToFile.write("Tss,qs: " + Tssqs);
				writeToFile.write("\n");

				double Tbsqs = Math.abs(((avgRunTimesBub[i] / nIterations) - (avgRunTimesQui[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (bubSd - quiSd));
				writeToFile.write("Tbs,qs: " + Tbsqs);
				writeToFile.write("\n");

				double Tisqs = Math.abs(((avgRunTimesIns[i] / nIterations) - (avgRunTimesQui[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (insSd - quiSd));
				writeToFile.write("Tis,qs: " + Tisqs);
				writeToFile.write("\n");

				double Tmsqs = Math.abs(((avgRunTimesMer[i] / nIterations) - (avgRunTimesQui[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (merSd - quiSd));
				writeToFile.write("Tms,qs: " + Tmsqs);
				writeToFile.write("\n");

				double Tssrs = Math.abs(((avgRunTimesSel[i] / nIterations) - (avgRunTimesRad[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (selSd - radSd));
				writeToFile.write("Tss,rs: " + Tssrs);
				writeToFile.write("\n");

				double Tbsrs = Math.abs(((avgRunTimesBub[i] / nIterations) - (avgRunTimesRad[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (bubSd - radSd));
				writeToFile.write("Tbs,rs: " + Tbsrs);
				writeToFile.write("\n");

				double Tisrs = Math.abs(((avgRunTimesIns[i] / nIterations) - (avgRunTimesRad[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (insSd - radSd));
				writeToFile.write("Tis,rs: " + Tisrs);
				writeToFile.write("\n");

				double Tmsrs = Math.abs(((avgRunTimesMer[i] / nIterations) - (avgRunTimesRad[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (merSd - radSd));
				writeToFile.write("Tms,rs: " + Tmsrs);
				writeToFile.write("\n");

				double Tqsrs = Math.abs(((avgRunTimesQui[i] / nIterations) - (avgRunTimesRad[i] / nIterations))
						* (Math.pow(nIterations, 0.5)) / (quiSd - radSd));
				writeToFile.write("Tqs,rs: " + Tqsrs);
				writeToFile.write("\n");

				writeToFile.write("\n");
				writeToFile.close();

			} catch (IOException e) {

			}

		}

	}// end main

}// end SortDriver

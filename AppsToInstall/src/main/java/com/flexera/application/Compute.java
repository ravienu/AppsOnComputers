package com.flexera.application;

import com.flexera.model.User;

import java.util.Map;

/**
 * This class computes the total number of applications required to install
 */
public class Compute {
    /**
     * @param users
     * identifies laptop, desktop counts and divide them in to valid pairs for accurate application count
     */
    public int workOnLapDeskCount(Map<Integer, User> users) {
        int totalApps = 0;
        int pairCount = 0;
        int extraDeviceCount = 0;

        for (Integer i : users.keySet()) {
            int lapCount = users.get(i).getLaptopCount();
            int deskCount = users.get(i).getDesktopCount();

            String additionalType = null;
            if (deskCount > lapCount) {
                additionalType = "D";
                extraDeviceCount = deskCount - lapCount;
                pairCount = deskCount - extraDeviceCount;
            } else if (deskCount < lapCount) {
                additionalType = "L";
                extraDeviceCount = lapCount - deskCount;
                pairCount = lapCount - extraDeviceCount;
            } else if (deskCount == lapCount) {
                pairCount = deskCount;
            }

            totalApps = totalAppsCount(totalApps, extraDeviceCount, pairCount, additionalType);
        }
        return totalApps;
    }

    /**
     *
     * @param totalApps
     * @param extraDeviceCount
     * @param pairCount
     * @param additionalType
     * @return
     *
     * This method do a final count of total apps required
     */

   public int totalAppsCount(int totalApps, int extraDeviceCount, int pairCount, String additionalType)
    {
        totalApps = totalApps + pairCount;
        if (extraDeviceCount != 0 && additionalType != null) {
            if (additionalType.equalsIgnoreCase("D")) {
                totalApps = totalApps + extraDeviceCount;
            } else if (additionalType.equalsIgnoreCase("L")) {
                int count = extraDeviceCount % 2;
                if (count == 0) {
                    totalApps = totalApps + extraDeviceCount/2;
                } else {
                    totalApps = totalApps + extraDeviceCount/2 + 1;

                }
            }
        }

        return  totalApps;
    }
} //Test comment

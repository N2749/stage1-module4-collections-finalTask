package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> projectsOfGivenDev = new ArrayList<>();
        for (Map.Entry<String, Set<String>> projectInfo : projects.entrySet()) {
            if (projectInfo.getValue().contains(developer))
                projectsOfGivenDev.add(projectInfo.getKey());
        }
        projectsOfGivenDev.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return -1;
            if (s1.length() < s2.length()) return 1;
            return s2.compareTo(s1);
        });
        return projectsOfGivenDev;
    }
}

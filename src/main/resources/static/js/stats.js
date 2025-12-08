async function loadStats() {
    const response = await fetch("/api/stats");
    const data = await response.json();

    // Memory
    document.getElementById("freeMem").textContent = data.allMemory.freeRAM + " GB";
    document.getElementById("usedMem").textContent = data.allMemory.usedRAM + " GB";
    document.getElementById("totalMem").textContent = data.allMemory.totalRAM + " GB";

    // CPU
    document.getElementById("processCpu").textContent = data.allCPU.cpuProcessLoad + "%";
    document.getElementById("systemCpu").textContent = data.allCPU.cpuSystemLoad + "%";
    document.getElementById("totalCpu").textContent = data.allCPU.cpuTotalLoad + "%";

    // Disk
    document.getElementById("totalDisk").textContent = data.allDisk.totalDisk + " GB";
    document.getElementById("freeDisk").textContent = data.allDisk.freeDisk + " GB";

    // Uptime
    document.getElementById("uptime").textContent = data.allUptime.uptime + " s";
}

loadStats();
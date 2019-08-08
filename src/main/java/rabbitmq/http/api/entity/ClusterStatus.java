package rabbitmq.http.api.entity;


// 集群状态实体类
public class ClusterStatus {

    private String nodeName;
    private long diskFree;
    private long diskLimit;
    private long fdUsed;
    private long fdTotal;
    private long socketUsed;
    private long socketTotal;
    private long memoryUsed;
    private long memoryLimit;
    private long procUsed;
    private long procTotal;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public long getDiskFree() {
        return diskFree;
    }

    public void setDiskFree(long diskFree) {
        this.diskFree = diskFree;
    }

    public long getDiskLimit() {
        return diskLimit;
    }

    public void setDiskLimit(long diskLimit) {
        this.diskLimit = diskLimit;
    }

    public long getFdUsed() {
        return fdUsed;
    }

    public void setFdUsed(long fdUsed) {
        this.fdUsed = fdUsed;
    }

    public long getFdTotal() {
        return fdTotal;
    }

    public void setFdTotal(long fdTotal) {
        this.fdTotal = fdTotal;
    }

    public long getSocketUsed() {
        return socketUsed;
    }

    public void setSocketUsed(long socketUsed) {
        this.socketUsed = socketUsed;
    }

    public long getSocketTotal() {
        return socketTotal;
    }

    public void setSocketTotal(long socketTotal) {
        this.socketTotal = socketTotal;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public long getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(long memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public long getProcUsed() {
        return procUsed;
    }

    public void setProcUsed(long procUsed) {
        this.procUsed = procUsed;
    }

    public long getProcTotal() {
        return procTotal;
    }

    public void setProcTotal(long procTotal) {
        this.procTotal = procTotal;
    }

    @Override
    public String toString() {
        return "ClusterStatus{" +
                "nodeName='" + nodeName + '\'' +
                ", diskFree=" + diskFree +
                ", diskLimit=" + diskLimit +
                ", fdUsed=" + fdUsed +
                ", fdTotal=" + fdTotal +
                ", socketUsed=" + socketUsed +
                ", socketTotal=" + socketTotal +
                ", memoryUsed=" + memoryUsed +
                ", memoryLimit=" + memoryLimit +
                ", procUsed=" + procUsed +
                ", procTotal=" + procTotal +
                '}';
    }
}



class Computer {

    private String cpu;
    private int ram;
    private int storage;
    private String gpu;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    public void display() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("GPU: " + gpu);
        System.out.println();
    }

    public static class Builder {

        private String cpu;
        private int ram;
        private int storage;
        private String gpu;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {

    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(1000)
                .setGPU("NVIDIA RTX 4080")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(8)
                .setStorage(512)
                .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.display();

        System.out.println("Office PC Configuration:");
        officePC.display();
    }
}
